# Resume Generator Website using KMP WebAssembly

This project is a resume generator website built using Kotlin Multiplatform (KMP) WebAssembly (wasm). The website allows users to create their resumes by providing input in JSON format. It offers a variety of customization options for text appearance, such as colors, font weights, and styles. The generated resume can be customized using predefined colors, font weights, and styles.

## Features

- Generate personalized resumes using JSON input.
- Customize text appearance with predefined colors, font weights, and styles.
- Various components available for structuring the resume:
  - **BasicTextWidgetConfig**: Represents a basic text element with customizable attributes.
  - **BulletinTextWidgetConfig**: Creates a bullet-point list with customizable text configurations.
  - **DividerWidgetConfig**: Adds a horizontal divider with customizable thickness and color.
  - **MiddleBulletinRowTextWidgetConfig**: Creates a row of text elements with bullet points and customizable configurations.
  - **RowTextWidgetConfig**: Represents a row of two text elements with customizable configurations.
  - **SpacerWidgetConfig**: Adds vertical spacing between components.

## Customization Options

### Colors

The following colors can be used:

- "black" -> Color.Black
- "white" -> Color.White
- "red" -> Color.Red
- "green" -> Color.Green
- "blue" -> Color.Blue
- "yellow" -> Color.Yellow
- "cyan" -> Color.Cyan
- "magenta" -> Color.Magenta
- "gray", "grey" -> Color.Gray
- "lightGray", "lightGrey" -> Color.LightGray
- "darkGray", "darkGrey" -> Color.DarkGray
- "transparent" -> Color.Transparent

### Font Weights

Choose from the following font weights:

- "light", "thin" -> FontWeight.Light
- "normal", "regular" -> FontWeight.Normal
- "medium" -> FontWeight.Medium
- "bold" -> FontWeight.Bold
- "semiBold" -> FontWeight.SemiBold

### Styles

Select text styles:

- "italic", "italics" -> FontStyle.Italic
- "normal" -> FontStyle.Normal
- else -> FontStyle.Normal

## Components

### BasicTextWidgetConfig

A basic text element with customizable attributes:

- **text**: The text content.
- **url**: URL associated with the text.
- **shouldUnderLineUrl**: Whether the URL should be underlined (default: true).
- **textConfig**: Text configuration containing color, font weight, text size, and font style.
- **widgetId**: Identifier for the widget.
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values.

### BulletinTextWidgetConfig

Creates a bullet-point list with customizable text configurations:

- **bulletinText**: The bullet point character (default: "•").
- **textConfigsList**: List of BasicTextWidgetConfig for the bullet points.
- **widgetId**: Identifier for the widget.
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values.

### DividerWidgetConfig

Adds a horizontal divider with customizable attributes:

- **thickness**: The thickness of the divider line.
- **color**: Color of the divider.
- **colorAlpha**: Alpha value for the color (default: 1.0).
- **widgetId**: Identifier for the widget.
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values.

### MiddleBulletinRowTextWidgetConfig

Creates a row of text elements with bullet points and customizable configurations:

- **bulletinText**: The bullet point character (default: "•").
- **firstTextWidgetConfig**, **secondTextWidgetConfig**, **thirdTextWidgetConfig**, **fourthTextWidgetConfig**: BasicTextWidgetConfig for each element.
- **widgetId**: Identifier for the widget.
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values.

### RowTextWidgetConfig

Represents a row of two text elements with customizable configurations:

- **firstTextWidgetConfig**, **secondTextWidgetConfig**: BasicTextWidgetConfig for each element.
- **widgetId**: Identifier for the widget.
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values.

### SpacerWidgetConfig

Adds vertical spacing between components:

- **space**: The amount of spacing.
- **widgetId**: Identifier for the widget.
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values.

## Getting Started

To use this resume generator website, follow these steps:

1. Clone the repository.
2. Open the project using your preferred Kotlin IDE.
3. Modify the JSON input according to your resume content and customization preferences.
4. Build and run the KMP wasm application.
5. View and download your personalized resume.

## Conclusion

This KMP wasm-powered website provides an innovative way to create personalized resumes using JSON input. With a range of customization options for text appearance and multiple components to structure the content, it offers a user-friendly and flexible experience for generating impressive resumes.
