package com.banktweaks;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

import java.awt.Color;

@ConfigGroup("banktweaks")
public interface BankTweaksConfig extends Config
{
	@ConfigItem(
		keyName = "wornItemsPosition",
		name = "Worn Items Button Position",
		description = "Which side of the bank the worn items button appears on",
		position = 0
	)
	default ButtonPosition wornItemsPosition()
	{
		return ButtonPosition.LEFT;
	}

	enum ButtonPosition
	{
		LEFT("Left"),
		RIGHT("Right (Default)");

		private final String name;

		ButtonPosition(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return name;
		}
	}

	@ConfigSection(
		name = "Tab Names",
		description = "Custom names for bank tabs. Clear fields to reset tab names.",
		position = 1
	)
	String tabNamesSection = "tabNames";

	@ConfigItem(
		keyName = "enableTabNames",
		name = "Enable Custom Tab Names",
		description = "Toggle custom tab name tooltips on/off",
		section = tabNamesSection,
		position = 0
	)
	default boolean enableTabNames() { return true; }

	@ConfigItem(keyName = "tab1Color", name = "Tab 1", description = "Color for tab 1 tooltip", section = tabNamesSection, position = 1)
	default Color tab1Color() { return new Color(0xff9040); }

	@ConfigItem(keyName = "tab1Name", name = "", description = "Custom name for tab 1", section = tabNamesSection, position = 2)
	default String tab1Name() { return ""; }

	@ConfigItem(keyName = "tab2Color", name = "Tab 2", description = "Color for tab 2 tooltip", section = tabNamesSection, position = 3)
	default Color tab2Color() { return new Color(0xff9040); }

	@ConfigItem(keyName = "tab2Name", name = "", description = "Custom name for tab 2", section = tabNamesSection, position = 4)
	default String tab2Name() { return ""; }

	@ConfigItem(keyName = "tab3Color", name = "Tab 3", description = "Color for tab 3 tooltip", section = tabNamesSection, position = 5)
	default Color tab3Color() { return new Color(0xff9040); }

	@ConfigItem(keyName = "tab3Name", name = "", description = "Custom name for tab 3", section = tabNamesSection, position = 6)
	default String tab3Name() { return ""; }

	@ConfigItem(keyName = "tab4Color", name = "Tab 4", description = "Color for tab 4 tooltip", section = tabNamesSection, position = 7)
	default Color tab4Color() { return new Color(0xff9040); }

	@ConfigItem(keyName = "tab4Name", name = "", description = "Custom name for tab 4", section = tabNamesSection, position = 8)
	default String tab4Name() { return ""; }

	@ConfigItem(keyName = "tab5Color", name = "Tab 5", description = "Color for tab 5 tooltip", section = tabNamesSection, position = 9)
	default Color tab5Color() { return new Color(0xff9040); }

	@ConfigItem(keyName = "tab5Name", name = "", description = "Custom name for tab 5", section = tabNamesSection, position = 10)
	default String tab5Name() { return ""; }

	@ConfigItem(keyName = "tab6Color", name = "Tab 6", description = "Color for tab 6 tooltip", section = tabNamesSection, position = 11)
	default Color tab6Color() { return new Color(0xff9040); }

	@ConfigItem(keyName = "tab6Name", name = "", description = "Custom name for tab 6", section = tabNamesSection, position = 12)
	default String tab6Name() { return ""; }

	@ConfigItem(keyName = "tab7Color", name = "Tab 7", description = "Color for tab 7 tooltip", section = tabNamesSection, position = 13)
	default Color tab7Color() { return new Color(0xff9040); }

	@ConfigItem(keyName = "tab7Name", name = "", description = "Custom name for tab 7", section = tabNamesSection, position = 14)
	default String tab7Name() { return ""; }

	@ConfigItem(keyName = "tab8Color", name = "Tab 8", description = "Color for tab 8 tooltip", section = tabNamesSection, position = 15)
	default Color tab8Color() { return new Color(0xff9040); }

	@ConfigItem(keyName = "tab8Name", name = "", description = "Custom name for tab 8", section = tabNamesSection, position = 16)
	default String tab8Name() { return ""; }

	@ConfigItem(keyName = "tab9Color", name = "Tab 9", description = "Color for tab 9 tooltip", section = tabNamesSection, position = 17)
	default Color tab9Color() { return new Color(0xff9040); }

	@ConfigItem(keyName = "tab9Name", name = "", description = "Custom name for tab 9", section = tabNamesSection, position = 18)
	default String tab9Name() { return ""; }
}
