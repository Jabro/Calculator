set speech = CreateObject("SAPI.SpVoice")
speech.Speak Wscript.Arguments(0), 3
speech.WaitUntilDone(2000)