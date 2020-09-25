package commands.client;

import commands.ActionCommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.ToLoginFormCommand;

public enum CommandEnum {
	LOGIN {
			{
				this.command = new LoginCommand();
			}
	},
	LOGOUT {
			{
				this.command = new LogoutCommand();
			}
	},
	TOLOGINFORM {
			{
				this.command = new ToLoginFormCommand();
			}
	};
		ActionCommand command;
		public ActionCommand getCurrentCommand() {
		return command;
		}
}
