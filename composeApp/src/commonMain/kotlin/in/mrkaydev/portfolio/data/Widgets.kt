package `in`.mrkaydev.portfolio.data

sealed class Widgets(val widgetName:String) {
    object BasicTextWidgetId : Widgets("basicText")
    object RowTextWidgetId : Widgets("rowText")
    object DividerWidgetId : Widgets("divider")
}