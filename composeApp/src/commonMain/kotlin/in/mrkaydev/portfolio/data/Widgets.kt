package `in`.mrkaydev.portfolio.data

@kotlinx.serialization.Serializable
sealed class Widgets(val widgetName:String) {
    object BasicTextWidgetId : Widgets("BasicTextWidgetId")
    object RowTextWidgetId : Widgets("RowTextWidgetId")
    object MiddleBulletinRowTextWidgetId : Widgets("MiddleBulletinRowTextWidgetId")
    object BulletinTextWidgetId : Widgets("BulletinTextWidgetId")
    object SpacerWidgetId : Widgets("SpacerWidgetId")
    object DividerWidgetId : Widgets("DividerWidgetId")
}