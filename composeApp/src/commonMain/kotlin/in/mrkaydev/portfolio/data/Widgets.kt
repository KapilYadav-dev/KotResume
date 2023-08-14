package `in`.mrkaydev.portfolio.data

@kotlinx.serialization.Serializable
sealed class Widgets(val widgetName:String) {
    object BasicTextWidgetId : Widgets("basicText")
    object RowTextWidgetId : Widgets("rowText")
    object MiddleBulletinRowTextWidgetId : Widgets("middleBulletinRowText")
    object BulletinTextWidgetId : Widgets("BulletinText")
    object SpacerWidgetId : Widgets("spacer")
    object DividerWidgetId : Widgets("divider")
}