# PhotoGallery

Photo Gallery is a small demo application based on modern Android tech-stacks like Jetpack Compose using [PixaBay API](https://pixabay.com/). Also fetching data from the network and integrating persisted data in the database via repository pattern.
This app was developed using Clean Architecture.

# Screens
<table>
  <tr>
    <th>GalleryImageList</th>
    <th>GalleryImageDetails</th>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/36087806/216847518-56130f38-d85e-4792-8df6-e8688daa2faa.png"   height="550"  width="250"/></td>
    <td><img src="https://user-images.githubusercontent.com/36087806/216847520-52b1a7fb-dc55-4059-ba89-e3f9e9ddf340.png"   height="550"  width="250"/></td>
  </tr>
</table>

# How to build on your environment

Add your [PixaBay API](https://pixabay.com/) key in local.properties file.

````
PIXABAY_API=YOUR_API_KEY
````


<img src="https://user-images.githubusercontent.com/36087806/216851697-ddc9b7fb-b64f-483c-9c40-8f7b894e1008.gif" align="right" width="23%"/>

# Tech stack & Open-source libraries
- 100% Kotlin based app
- Minimum sdk 24 supporting Android 7 and above
- Architecture
  - Clean Architecture (Use case based architecture)
  - Repository pattern
- Jetpack Compose
- Accompanist
- Retrofit2
- Coroutines
- Flow
- Coil
- Mockk 
- Room 
- Hilt
- Timber

# Download
Download the [APK](https://github.com/MohitMandalia/PhotoGallery/releases/tag/v1.0-alpha) here
