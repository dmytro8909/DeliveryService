package commands.client;

import commands.ActionCommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.RegisterCommand;
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
	REGISTER {
			{
				this.command = new RegisterCommand();
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
