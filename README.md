Tutorial-Mod
============

How to begin
------------

_NOTA BENE: All versions mentioned have been tested as of 2014-11-24 but are subject to change in the future_

1. Download and install the Java Development Kit (JDK, Version 1.7+)
2. Go to [http://files.minecraftforge.net/](http://files.minecraftforge.net/) and download the _latest version of the Recommended source_ ("Src").  (Version 1.7.10)
3. Extract the zip file and rename the folder to 'forge'
4. Decompile the Minecraft jar files and set up workspace for Eclipse [IDE](http://en.wikipedia.org/wiki/Integrated_development_environment)
  1. On Windows:  Click on the gradlew.bat file
  2. On Mac/Linux: (in a Terminal)  
  
    ```bash
    cd forge
    ./gradlew setupDecompWorkspace
    ./gradlew eclipse  # for Eclipse
    ```
5. Decide on your developer signature for your mod.  By convention this is your email address or website in reverse order
   - Examples: 
     - 'johndoe AT gmail.com'  --> 'com.gmail.johndoe'
     - 'janedoe.net' --> 'net.janedoe'
6. Fork this repository!  Create your own copy of Tutorial-Mod on your Github account.
7. Clone this repository in the `forge/src/main/java/` directory as the domain of your signature
  
  ```bash
  DOMAIN=com  # Set this to your domain (com, net, org, biz, jp, ...)
  USERNAME=jdoe  # Your Github username
  git clone https://github.com/${USERNAME}/Tutorial-Mod.git ${DOMAIN}
  ```
8. Rename the parent directory of `tutorialmod/` to the rest of your signature:

  ```bash
  cd com
  SIGNATURE=com.gmail.johndoe
  git checkout -b ${SIGNATURE}
  git mv coderdojoia gmail/johndoe
  find gmail/johndoe -type f -name *.java -exec sed -i old s/org.coderdojoia.tutorialmod/${SIGNATURE}.tutorialmod/g {} \;
  git commit -a -m "Updated directory structure to com/gmail/johndoe"
  ```
  
Acknowledgements
================
- fisherman77 for taking the time to create the parent work this is based on
- bucktower from whom I was able to fork this project
- Notch for creating Minecraft ;-) 
