# KotResume

This is a resume generator website built using Kotlin Multiplatform (KMP) WebAssembly (wasm). The
website allows users to create their resumes by providing input in JSON format. It offers a variety
of customization options for text appearance, such as colors, font weights, and styles. The
generated resume can be customized using predefined colors, font weights, and styles.

## Demo

![Image 1](https://raw.githubusercontent.com/KapilYadav-dev/KotResume/main/images/demo.png)

## Features

- Generate personalized resumes using JSON input.
- Customize text appearance with predefined colors, font weights, and styles.
- Various components available for structuring the resume:
    - **BasicTextWidgetConfig**: Represents a basic text element with customizable attributes.
    - **BulletinTextWidgetConfig**: Creates a bullet-point list with customizable text
      configurations.
    - **DividerWidgetConfig**: Adds a horizontal divider with customizable thickness and color.
    - **MiddleBulletinRowTextWidgetConfig**: Creates a row of text elements with bullet points and
      customizable configurations.
    - **RowTextWidgetConfig**: Represents a row of two text elements with customizable
      configurations.
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
- else -> Color.Black

### Font Weights

Choose from the following font weights:

- "light", "thin" -> FontWeight.Light
- "normal", "regular" -> FontWeight.Normal
- "medium" -> FontWeight.Medium
- "bold" -> FontWeight.Bold
- "semiBold" -> FontWeight.SemiBold
- else -> FontWeight.Normal

### Styles

Select text styles:

- "italic", "italics" -> FontStyle.Italic
- "normal" -> FontStyle.Normal
- else -> FontStyle.Normal

## Components

![Image 1](https://raw.githubusercontent.com/KapilYadav-dev/KotResume/main/images/understanding.png)

### BasicTextWidgetConfig

A basic text element with customizable attributes:

```kotlin
data class BasicTextWidgetConfig(
    val text: String? = null,
    val url: String? = null,
    val shouldUnderLineUrl: Boolean? = true,
    val textConfig: TextConfig = TextConfig(),
    val widgetId: String = Widgets.BasicTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
) {
    @kotlinx.serialization.Serializable
    data class TextConfig(
        val color: String? = null,
        val fontWeight: String? = null,
        val textSize: Int? = null,
        val fontStyle: String? = null
    )
}
```

- **text**: The text content.
- **url**: URL associated with the text.
- **shouldUnderLineUrl**: Whether the URL should be underlined (default: true).
- **textConfig**: Text configuration containing color in String, font weight in String , text size
  in Int, and font style in String.
- **widgetId**: I"BasicTextWidgetId"
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values in int. ( e.g
  32 i.e 32.dp )

### BulletinTextWidgetConfig

Creates a bullet-point list with customizable text configurations:

- **bulletinText**: The bullet point character (default: "•").
- **textConfigsList**: List of BasicTextWidgetConfig for the bullet points.
- **widgetId**: "BulletinTextWidgetId"
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values in int. ( e.g
  32 i.e 32.dp )

### DividerWidgetConfig

Adds a horizontal divider with customizable attributes:

```kotlin
data class BulletinTextWidgetConfig(
    val bulletinText: String = "•",
    val textConfigsList: List<BasicTextWidgetConfig>? = null,
    val widgetId: String = Widgets.BulletinTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 32,
    val endPadding: Int = 0
)
```

- **thickness**: The thickness of the divider line.
- **color**: Color of the divider.
- **colorAlpha**: Alpha value for the color (default: 1.0).
- **widgetId**: "DividerWidgetId"
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values in int. ( e.g
  32 i.e 32.dp )

### MiddleBulletinRowTextWidgetConfig

Creates a row of text elements with bullet points and customizable configurations:

```kotlin
data class MiddleBulletinRowTextWidgetConfig(
    val bulletinText: String = "•",
    val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    val thirdTextWidgetConfig: BasicTextWidgetConfig? = null,
    val fourthTextWidgetConfig: BasicTextWidgetConfig? = null,
    val widgetId: String = Widgets.MiddleBulletinRowTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
)
```

- **bulletinText**: The bullet point character (default: "•").
- **firstTextWidgetConfig**, **secondTextWidgetConfig**, **thirdTextWidgetConfig**, **
  fourthTextWidgetConfig**: BasicTextWidgetConfig for each element.
- **widgetId**: "MiddleBulletinRowTextWidgetId"
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values in int. ( e.g
  32 i.e 32.dp )

### RowTextWidgetConfig

Represents a row of two text elements with customizable configurations:

```kotlin
data class RowTextWidgetConfig(
    val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    val widgetId: String = Widgets.RowTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
)
```

- **firstTextWidgetConfig**, **secondTextWidgetConfig**: BasicTextWidgetConfig for each element.
- **widgetId**: "RowTextWidgetId"
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values in int. ( e.g
  32 i.e 32.dp )

### SpacerWidgetConfig

Adds vertical spacing between components:

```kotlin
data class SpacerWidgetConfig(
    val space: Int? = null,
    val widgetId: String = Widgets.SpacerWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
)
```

- **space**: The amount of spacing in int. ( e.g 32 i.e 32.dp )
- **widgetId**: "SpacerWidgetId"
- **topPadding**, **bottomPadding**, **startPadding**, **endPadding**: Padding values.

## Example Json

<details>
<summary>Click to expand the code for example json</summary>

```json
{
  "resumeUrl": "https://d1fdloi71mui9q.cloudfront.net/Pz93R8fISZm11vhLK3Qx_KapilResume.pdf",
  "resumeName": "KapilYadav-Resume.pdf",
  "resumeDataList": [
    {
      "widgetId": "RowTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0,
      "firstTextWidgetConfig": {
        "text": "Kapil Yadav",
        "textConfig": {
          "color": "blue",
          "textSize": 16,
          "fontWeight": "bold"
        }
      },
      "secondTextWidgetConfig": {
        "text": "Email: infokaydev@gmail.com",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "normal"
        }
      }
    },
    {
      "widgetId": "RowTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0,
      "firstTextWidgetConfig": {
        "url": "https://linktr.ee/mrkaydev",
        "text": "All links here",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "normal"
        }
      },
      "secondTextWidgetConfig": {
        "text": "Mobile: +91-8920701834",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "normal"
        }
      }
    },
    {
      "space": 20,
      "widgetId": "SpacerWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "text": "Education",
      "widgetId": "BasicTextWidgetId",
      "endPadding": 0,
      "textConfig": {
        "color": "blue",
        "textSize": 16,
        "fontWeight": "bold"
      },
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "color": "black",
      "widgetId": "DividerWidgetId",
      "thickness": 1,
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "space": 20,
      "widgetId": "SpacerWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "widgetId": "MiddleBulletinRowTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "bulletinText": "•",
      "startPadding": 0,
      "bottomPadding": 0,
      "firstTextWidgetConfig": {
        "text": "Ajay Kumar Garg Engineering College",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "bold"
        }
      },
      "thirdTextWidgetConfig": {
        "text": "Bachelor of Technology in Computer Science Engineering; CGPA: <b>7.4</b>",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "fourthTextWidgetConfig": {
        "text": "Aug. 2019 – May. 2023",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "secondTextWidgetConfig": {
        "text": "Ghaziabad",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "normal"
        }
      }
    },
    {
      "space": 12,
      "widgetId": "SpacerWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "widgetId": "MiddleBulletinRowTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "bulletinText": "•",
      "startPadding": 0,
      "bottomPadding": 0,
      "firstTextWidgetConfig": {
        "text": "Rajkiya pratibha vikas vidyalaya",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "bold"
        }
      },
      "thirdTextWidgetConfig": {
        "text": "Class 12th; PERCENTAGE: <b>93.7%</b>",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontWeight": "normal"
        }
      },
      "fourthTextWidgetConfig": {
        "text": "April. 2018 – May. 2019",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontWeight": "normal"
        }
      },
      "secondTextWidgetConfig": {
        "text": "Surajmal vihar, New Delhi",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "normal"
        }
      }
    },
    {
      "space": 20,
      "widgetId": "SpacerWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "text": "Experience",
      "widgetId": "BasicTextWidgetId",
      "endPadding": 0,
      "textConfig": {
        "color": "blue",
        "textSize": 16,
        "fontWeight": "bold"
      },
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "color": "black",
      "widgetId": "DividerWidgetId",
      "thickness": 1,
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "space": 20,
      "widgetId": "SpacerWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "widgetId": "MiddleBulletinRowTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "bulletinText": "•",
      "startPadding": 0,
      "bottomPadding": 0,
      "firstTextWidgetConfig": {
        "text": "Mobile Premier League (MPL)",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "bold"
        }
      },
      "thirdTextWidgetConfig": {
        "text": "Android Intern",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "fourthTextWidgetConfig": {
        "text": "April 2023 - Present",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "secondTextWidgetConfig": {
        "text": "Bangalore, IN (Remote)",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "normal"
        }
      }
    },
    {
      "widgetId": "BulletinTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0,
      "textConfigsList": [
        {
          "text": "improved app startup time from <b>400 ms to 20 ms.</b>",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "Reduced app size around <b>20 Mb</b>",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "Fixed framework crashes and setup Firebase crashlytics around <b>99.7%</b>",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "Added a pre <b>gradle task</b> to check RN asset naming and also reduce webp size using cwebp as a pregradle task to improve storage utilisation.",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "Added <b>Ruler by Spotify</b> as a post task to generate App Size distribution report and automate that to <b>Slack Ci build.</b>",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "worked with <b>MPL internal SDK’s</b> which are being used in multiple products.",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        }
      ]
    },
    {
      "space": 8,
      "widgetId": "SpacerWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "widgetId": "MiddleBulletinRowTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "bulletinText": "•",
      "startPadding": 0,
      "bottomPadding": 0,
      "firstTextWidgetConfig": {
        "text": "INDMoney",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "bold"
        }
      },
      "thirdTextWidgetConfig": {
        "text": "Android Intern",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "fourthTextWidgetConfig": {
        "text": "Sept 2022 - March 2023",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "secondTextWidgetConfig": {
        "text": "Gurugram, IN (Remote)",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "normal"
        }
      }
    },
    {
      "widgetId": "BulletinTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0,
      "textConfigsList": [
        {
          "text": "was responsible for the whole <b>Mutual funds vertical.</b>",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "was the DRI for implementation of <b>Sentry SDK.</b>",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "worked on platform task for improving <b>Janky frames.</b>",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        }
      ]
    },
    {
      "space": 8,
      "widgetId": "SpacerWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "widgetId": "MiddleBulletinRowTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "bulletinText": "•",
      "startPadding": 0,
      "bottomPadding": 0,
      "firstTextWidgetConfig": {
        "text": "Atom EI",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "bold"
        }
      },
      "thirdTextWidgetConfig": {
        "text": "Android Intern",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "fourthTextWidgetConfig": {
        "text": "June 2022 - Sept 2022",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "secondTextWidgetConfig": {
        "text": "Gurugram, IN (Remote)",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "normal"
        }
      }
    },
    {
      "widgetId": "BulletinTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0,
      "textConfigsList": [
        {
          "text": "<b>Led Personalized Time feature :</b> Added a feature in prod release for Personalized meditation time for making flexible meditation for the user. Bug-free in 1st e2e testing itself.",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "<b>Image similarity algorithm :</b> Worked upon <b>Phash algorithm</b> which converted to a library in kotlin for internal use so that we can achieve Image similarity stable way with more than <b>85% accuracy.</b>",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "<b>Fixed bug on the production line :</b> Fixed a critical bug which leads to crashing, thus Firebase crashlytics events dropped by <b>90%.</b>",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        }
      ]
    },
    {
      "space": 8,
      "widgetId": "SpacerWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0
    },
    {
      "widgetId": "MiddleBulletinRowTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "bulletinText": "•",
      "startPadding": 0,
      "bottomPadding": 0,
      "firstTextWidgetConfig": {
        "text": "Atom EI",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "bold"
        }
      },
      "thirdTextWidgetConfig": {
        "text": "Android Intern",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "fourthTextWidgetConfig": {
        "text": "June 2022 - Sept 2022",
        "textConfig": {
          "color": "black",
          "textSize": 14,
          "fontStyle": "italics",
          "fontWeight": "normal"
        }
      },
      "secondTextWidgetConfig": {
        "text": "Gurugram, IN (Remote)",
        "textConfig": {
          "color": "black",
          "textSize": 16,
          "fontWeight": "normal"
        }
      }
    },
    {
      "widgetId": "BulletinTextWidgetId",
      "endPadding": 0,
      "topPadding": 0,
      "startPadding": 0,
      "bottomPadding": 0,
      "textConfigsList": [
        {
          "text": "<b>Led Personalized Time feature :</b> Added a feature in prod release for Personalized meditation time for making flexible meditation for the user. Bug-free in 1st e2e testing itself.",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "<b>Image similarity algorithm :</b> Worked upon Phash algorithm which converted to a library in kotlin for internal use so that we can achieve Image similarity stable way with more than 85% accuracy.",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        },
        {
          "text": "<b>Fixed bug on the production line :</b> Fixed a critical bug which leads to crashing, thus Firebase crashlytics events dropped by 90%.",
          "textConfig": {
            "color": "black",
            "textSize": 14,
            "fontWeight": "normal"
          }
        }
      ]
    }
  ]
}
```

</details>

## How to make your Resume Website

To use this resume generator website, follow these steps:

1. Clone the repository.
2. Open the project using your preferred Kotlin IDE.
3. Modify the RESUME_JSON_URL url according to your resume content and customization preferences.
4. Build and run the KMP wasm application.
5. Upload it to netlify.

## Conclusion

This KMP wasm-powered website provides an innovative way to create personalized resumes using JSON
input. With a range of customization options for text appearance and multiple components to
structure the content, it offers a user-friendly and flexible experience for generating impressive
resumes.
