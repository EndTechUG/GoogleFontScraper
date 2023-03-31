# GoogleFontScraper
A simple Java app, that downloads and installs all currently available Google Fonts

## Setup
Just clone the repository
Create a application.properties file in the resources folder
Add the following:
```
key=<YOUR_GOOGLE_FONTS_API_KEY>
fontPath=<PATH_TO_YOUR_FONTS_FOLDER>
```
Attention! The fontPath is the directory where all your system fonts are located (e.g. Mac = /Library/Fonts/)
Attention! Remember to add a trailing / to the fontPath
