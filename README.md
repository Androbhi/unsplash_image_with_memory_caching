# unsplash_image_with_memory_caching

How to run the project?
- Download and Install the latest android studio from https://developer.android.com/studio 
- Clone the project and open it from the android studio
- Once the code is compiled successfully, run the code to test. 

What this project is about?
This project is using **unsplash** API to get the image urls and loading the image without 
any third party lirbrary. The loaded bitmap will be staored in LRU Memory cache. 

What's the project structure?
This project is built on MVVM architecture. This has mainly 2 modules 
1. app module - responsible for fetch the image urls from unsplach API and rendering the Images. 
                For UI portion, compose has been used.
2. imagedloader - Responsible for Loading the image and caching. 

Tech stacks used
- Kotlin
- Compose
- MVVM
- Dagger Hilt
- Retrofit
- LRU memory caching

Basic structure
<img width="781" alt="image" src="https://github.com/Androbhi/unsplash_image_with_memory_caching/assets/83126024/83ced3b1-2c9a-456b-8646-3cfd0b7b2418">









 





