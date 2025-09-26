import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

// Manual facade for Turndown library
@js.native
@JSImport("turndown", JSImport.Default)
class TurndownService(options: js.UndefOr[TurndownOptions] = js.undefined) extends js.Object {
  def turndown(html: String): String = js.native
}

@js.native
trait TurndownOptions extends js.Object {
  var headingStyle: js.UndefOr[String] = js.native
  var hr: js.UndefOr[String] = js.native
  var bulletListMarker: js.UndefOr[String] = js.native
  var codeBlockStyle: js.UndefOr[String] = js.native
  var fence: js.UndefOr[String] = js.native
  var emDelimiter: js.UndefOr[String] = js.native
  var strongDelimiter: js.UndefOr[String] = js.native
  var linkStyle: js.UndefOr[String] = js.native
  var linkReferenceStyle: js.UndefOr[String] = js.native
}

object TurndownOptions {
  def apply(
    headingStyle: js.UndefOr[String] = js.undefined,
    hr: js.UndefOr[String] = js.undefined,
    bulletListMarker: js.UndefOr[String] = js.undefined,
    codeBlockStyle: js.UndefOr[String] = js.undefined,
    fence: js.UndefOr[String] = js.undefined,
    emDelimiter: js.UndefOr[String] = js.undefined,
    strongDelimiter: js.UndefOr[String] = js.undefined,
    linkStyle: js.UndefOr[String] = js.undefined,
    linkReferenceStyle: js.UndefOr[String] = js.undefined
  ): TurndownOptions = {
    val options = js.Dynamic.literal().asInstanceOf[TurndownOptions]
    headingStyle.foreach(options.headingStyle = _)
    hr.foreach(options.hr = _)
    bulletListMarker.foreach(options.bulletListMarker = _)
    codeBlockStyle.foreach(options.codeBlockStyle = _)
    fence.foreach(options.fence = _)
    emDelimiter.foreach(options.emDelimiter = _)
    strongDelimiter.foreach(options.strongDelimiter = _)
    linkStyle.foreach(options.linkStyle = _)
    linkReferenceStyle.foreach(options.linkReferenceStyle = _)
    options
  }
}