# Customizing Stream Compose UI Components
Stream’s Compose UI components make it easy for you to customize them to your own requirements. In this article, you'll learn how to add your own colors, shapes and types.

You can find all the code in this article [on GitHub](https://github.com/wangerekaharun/StreamUICustomization).

**Note**: This article assumes you are familiar with Stream UI Components. If you're unfamiliar with [Stream Jetpack Compose UI Components](https://getstream.io/blog/jetpack-compose-sdk/), check out the [Jetpack Compose Chat Tutorial](https://getstream.io/chat/compose/tutorial/)

## Understanding `ChatTheme` Component

The `ChatTheme` component is the default wrapper for all your components. By default, it has properties that style the whole application. Some of these properties include but are not limited to: colors, typography and shapes. Using this, you can be able to provide a different set of colors, typography and shapes that apply to your whole chat app.

## Customizing your `ChatTheme` Component

To customize the `ChatTheme` component, you need to provide your own colors, shapes and typography. Doing this will override the default implementation provided by `ChatTheme`.

You'll be learning how you can add your custom implementations to all the styling properties. You'll start with the colors.

## Adding Custom Colors

To add colors from your own design style, you need to use the `StreamColors` class. This contains all colors in the Stream color palette.   

First, you need an object to define your own colors:

```kotlin
object CustomColors {
    val Primary = Color(0xFF69ABFD)
    val PrimaryDark = Color(0xFF478CE9)
    val PrimaryLight = Color(0xFFD0E8FD)
    val OverLay = Color(0xA0A2C8FF)
    val Accent = Color(0xFFA20DFF)
    val TextHigh = Color(0xFF1A1A1A)
    val TextLow = Color(0xFF2E2E2E)
}
```

In the code above, you define the custom colors that you'll use. It has different colors for components inside your app.

With your colors defined, you need to now specify colors for different components inside the `StreamColors`. This is how it looks like:

```kotlin
val CustomLightStreamColors
    @Composable
    get() = StreamColors.defaultColors().copy(
        textHighEmphasis = CustomColors.TextHigh,
        textLowEmphasis = CustomColors.TextLow,
        disabled = CustomColors.PrimaryDark,
        borders = CustomColors.Primary,
        inputBackground = CustomColors.PrimaryLight,
        appBackground = CustomColors.PrimaryLight,
        barsBackground = CustomColors.Primary,
        linkBackground = CustomColors.PrimaryLight,
        overlay = CustomColors.OverLay,
        overlayDark = CustomColors.PrimaryDark,
        primaryAccent = CustomColors.Accent,
        highlight = CustomColors.PrimaryDark,
        ownMessagesBackground = CustomColors.PrimaryDark,
        otherMessagesBackground = CustomColors.PrimaryDark,
        deletedMessagesBackgroundColor = CustomColors.PrimaryDark
    )
```

In the code above, you provide your custom colors for the various properties defined in this class. This will apply to your whole app. You can always change these values. Additionally, you can still re-use the default ones by using the `Stream.defaultColors()`. This returns an instance that contains the Stream color palette.

## Adding Custom Shapes

Shapes let you define the appearance of your components in your app. To customize the shapes, you use the `StreamShapes` class which has the shapes for different components.

```kotlin
val CustomStreamShapes = StreamShapes(
    avatar = RoundedCornerShape(40),
    myMessageBubble = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp),
    otherMessageBubble = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomEnd = 20.dp),
    inputField = RoundedCornerShape(24.dp),
    attachment = RoundedCornerShape(16.dp),
    imageThumbnail = RoundedCornerShape(10.dp),
    bottomSheet = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
)
```

Using the `StreamShapes` class, you're able to define the shapes for attachments bottom sheets, input fields, avatar,  image thumbnail and the message bubbles.

The last bit on customization is the typography which you'll learn about next.

## Adding Custom Typography

Typography allows you to add fonts to your app. The `StreamTypography` class lets you define custom Typography. First, you need to add your fonts inside the  **fonts** folder. Then create a variable for your added fonts:

```kotlin
val SourceCodePro = FontFamily(
    Font(R.font.sourcecodepro_regular),
    Font(R.font.sourcecodepro_bold, FontWeight.Bold)
)
```

This now enables you to use `SourceCodePro` font in your custom definitions.

```kotlin
val StreamCustomTypography = StreamTypography(
    title1 = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),

    title3 = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    title3Bold = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),

    body = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    bodyItalic = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 14.sp
    ),

    bodyBold = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),

    footnote = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    footnoteItalic = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 12.sp
    ),

    footnoteBold = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),

    captionBold = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),

    tabBar = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)
```

Here, you define all the text style properties that will be used across all the text style components in the app. With the `StreamTypography` class, if you only want to change the font family and not the values for other components, you can change it like this:

```kotlin
StreamTypography.defaultTypography(SourceCodePro)
```

This only changes the font family and other properties like font size and weight will remaing the same as the default Stream UI Components values.

Now that you have all the custom components defined, it's time you apply them to `ChatTheme`.

## Joining the Pieces Together

Defining custom `StreamTypography`, `StreamShapes` and `StreamColors` will not apply these changes to your app. You need to provide them to `ChatTheme`. You do this by wrapping your UI components with `ChatTheme` like so:

```kotlin
ChatTheme(
    shapes = CustomStreamShapes,
    colors = if (isSystemInDarkTheme()) StreamColors.defaultDarkColors() else CustomLightStreamColors,
    typography = StreamCustomTypography
) {
    ChannelsScreen(
        title = stringResource(id = R.string.app_name),
        onItemClick = { channel ->
            startActivity(MessagesActivity.getIntent(this, channel.cid))
        },
        onBackPressed = { finish() }
    )
}
```

Here's a breakdown of what the code above does:

- You use the `shapes` property to provide your custom shapes.
- You use `colors` to provide your custom colors. Here you also need to provide colors on dark mode. The above example uses the default ones from the Stream color palette. You can choose to provide a different one.
- You use `typography` to provide your custom typography.

You have to do this in all places where you have the `ChatTheme` for example the MessagesScreen if you have one. Failure to do so will result in the screen using the default Stream theming.

Your app will now look like this:

| ![channels_screen](images/channels_screen.png "Channels Screen.") | ![messages_screen](images/messages_screen.png "Messages Screen.") |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![channel_info_bottom_sheet](images/channel_info_bottom_sheet.png "Channel Info Bottom Sheet.") | ![attachments_bottom_sheet](images/attachments_bottom_sheet.png "Attachments Bottom Sheet.") |

You can see that the color across the whole app has changed to be blue. Additionally, the colors of other components have changed as per the colors that are in the `CustomLightStreamColors`. The corners on bottom sheets, input field, image thumber nail and messages bubbles are slightly more rounded. The avatar has changed from circle to squircle. The font for all text components is now **Source Code Pro**. 

There's the `StreamDimens` class that has different sizes that can you can customize. In case you might need to customize the sizes.

## Conclusion

In this article, you've learned how to add your own custom theming to  Stream Compose UI components. As you've seen it's easy to provide your own custom values to the different properties. This makes it easy for you to provide your own design system alongside the Stream UI Components.

You can find the full sample project with examples in this tutorial [on GitHub](https://github.com/wangerekaharun/StreamUICustomization).

The [Compose SDK](https://getstream.io/chat/docs/sdk/android/compose/overview/) is still in beta. In case you have any feedback on using the SDK, reach the team [on Twitter](https://twitter.com/getstream_io) and [on GitHub](https://github.com/GetStream/stream-chat-android).
