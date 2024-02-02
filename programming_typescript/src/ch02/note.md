# Set up a new typescript project in vscode

```bash
  # ctrl+` # open a terminal

  npm init # run in terminal, then press enter a few times

  npm install -g typescript # run in terminal, tsc --version

  npm install -g tslint # run in terminal

  npm install --save-dev typescript tslint @types/node # run in termail

  tslint --init # code style

  rm -rf tsconfig.json && tsc --init --sourceMap --rootDir src --outDir dist  # run in terminal

  mkdir -p src/ch02 # run in terminal

  echo 'console.log("hello")' > src/ch02/hello.ts # run in terminal

  # double click (open) src/ch2/hello.ts

  # click Run/Debug icon on the left-most pane, click 'create a launch.json file' link, click nodejs

  # F1, --select--> Tasks: Configure Default Build Task --> tsc: watch. create tasks.json # F1 is a vscode shortcut 

  # F1, --select--> Tasks: Run Build Task. create a new terminal to watching and tsc changes

  # double click (open) src/ch2/hello.ts, click run. the output of hello.ts is in DEBUG CONSOLE pane
```