import org.scalajs.dom
import org.scalajs.dom.document
import com.raquo.laminar.api.L.{*, given}
import scala.scalajs.js

import typings.quill.quillMod
import typings.quill.coreQuillMod.QuillOptions
import typings.quill.themesSnowMod

import io.github.nguyenyou.webawesome.laminar.*



@main
def main: Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    interactiveApp
  )

def interactiveApp =
  val hiVar = Var("Update me!")
  val editorText = Var("Hello from Quill!")
  val markdownText = Var("Hello from Quill!")

  // Theme management
  val isDarkMode = Var(false)
  val turndownService = new TurndownService()

  // Theme switcher using WebAwesome Switch component
  def themeDropdown =
    div(
      className := "theme-toggle-container",
      label(
        "🌙",
        Switch()(
          checked <-- isDarkMode.signal,
          onChange --> { (event: dom.Event) =>
            val target = event.target.asInstanceOf[dom.HTMLInputElement]
            isDarkMode.set(target.checked)
          }
        ),
        "☀️"
      )
    )

  // Apply theme to body
  val themeObserver = isDarkMode.signal --> { darkMode =>
    if (darkMode) {
      dom.document.body.setAttribute("data-theme", "dark")
    } else {
      dom.document.body.removeAttribute("data-theme")
    }
  }
  div(
    themeObserver,
    themeDropdown,
    h1(s"Hello Quill "),
    Button()("Click me"),
    div(
      idAttr := "editor",
      styleAttr := "height: 200px; border: 1px solid #ccc;",
      onMountCallback { ctx =>

        val opt = QuillOptions().setTheme("snow")

        val editor = quillMod.default(ctx.thisNode.ref, opt)

        editor.setText("Hello from Quill!")

        // Listen for text changes and update the reactive variable
        val changeHandler: js.Function = () => {
          val currentHtml = editor.getSemanticHTML()
          editorText.set(currentHtml)

          // Convert HTML to Markdown using turndown
          val markdown = turndownService.turndown(currentHtml)
          markdownText.set(markdown)
        }
        editor.on("text-change", changeHandler)
      }
    ),
    div(
      h3("HTML Output:"),
      p(
        className := "output-section",
        styleAttr := "padding: 10px; border: 1px solid; white-space: pre-wrap;",
        child.text <-- editorText.signal
      )
    ),
    div(
      h3("Markdown Output:"),
      p(
        className := "output-section-alt",
        styleAttr := "padding: 10px; border: 1px solid; white-space: pre-wrap;",
        child.text <-- markdownText.signal
      )
    )
  )