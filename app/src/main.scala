import org.scalajs.dom
import org.scalajs.dom.document
import com.raquo.laminar.api.L.{*, given}
import scala.scalajs.js

import typings.quill.quillMod
import typings.quill.coreQuillMod.QuillOptions
import typings.quill.themesSnowMod

@main
def main: Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    interactiveApp
  )

def interactiveApp =
  val hiVar = Var("Update me!")
  val editorText = Var("Hello from Quill!")

  div(
    h1(s"Hello Quill "),
    div(
      idAttr := "editor",
      styleAttr := "height: 200px; border: 1px solid #ccc;",
      onMountCallback { ctx =>

        val opt = QuillOptions().setTheme("snow")

        val editor = quillMod.default(ctx.thisNode.ref, opt)

        editor.setText("Hello from Quill!")

        // Listen for text changes and update the reactive variable
        val changeHandler: js.Function = () => {
          val currentText = editor.getText()
          editorText.set(currentText)
        }
        editor.on("text-change", changeHandler)
      }
    ),
    p(
      "Editor content: ",
      child.text <-- editorText.signal
    )
  )