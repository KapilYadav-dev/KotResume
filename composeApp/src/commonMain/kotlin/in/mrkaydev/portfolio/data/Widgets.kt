package `in`.mrkaydev.portfolio.data

sealed class Widgets(val widgetName:String) {
    object BasicTextWidgetId : Widgets("basicText")
}