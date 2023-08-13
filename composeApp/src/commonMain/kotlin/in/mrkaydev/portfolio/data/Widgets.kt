package `in`.mrkaydev.portfolio.data

sealed class Widgets(val widgetName:String) {
    object BasicTextWidgetId : Widgets("basicText")
    object RowTextWidgetId : Widgets("rowText")
    object MiddleBulletinRowTextWidgetId : Widgets("middleBulletinRowText")
    object SpacerWidgetId : Widgets("spacer")
    object DividerWidgetId : Widgets("divider")
}