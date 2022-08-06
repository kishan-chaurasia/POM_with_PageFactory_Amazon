WinWaitActive("#32770", "", "5")
ControlFocus("Open", "", "Edit1")
ControlSetText("Open", "", "Edit1", $CmdLIne[1])
ControlClick("Open", "", "Button1")
