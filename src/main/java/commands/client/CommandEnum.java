package commands.client;

import commands.ActionCommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.ToLoginFormCommand;
import commands.ToRegisterFormCommand;

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
	},
	TOREGISTERFORM {
			{
				this.command = new ToRegisterFormCommand();
			}
	};
		ActionCommand command;
		public ActionCommand getCurrentCommand() {
		return command;
		}
}
