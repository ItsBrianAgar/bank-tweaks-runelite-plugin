package com.banktweaks;

import com.google.inject.Provides;
import javax.inject.Inject;
import java.awt.Color;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.PostClientTick;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Bank Tweaks",
	description = "Small bank UI customizations - button position and tab labels",
	tags = {"bank", "ui", "tabs", "tweaks"}
)
public class BankTweaksPlugin extends Plugin
{
	private static final int WORN_ITEMS_X_LEFT = 8;
	private static final int WORN_ITEMS_X_RIGHT = 445;

	@Inject
	private Client client;

	@Inject
	private BankTweaksConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Bank Tweaks started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Bank Tweaks stopped!");
	}

	@Subscribe
	public void onPostClientTick(PostClientTick event)
	{
		// Handle worn items button position
		Widget wornItemsButton = client.getWidget(12, 100);
		if (wornItemsButton != null)
		{
			if (config.wornItemsPosition() == BankTweaksConfig.ButtonPosition.LEFT)
			{
				wornItemsButton.setForcedPosition(WORN_ITEMS_X_LEFT, wornItemsButton.getRelativeY());
			}
			else
			{
				wornItemsButton.setForcedPosition(WORN_ITEMS_X_RIGHT, wornItemsButton.getRelativeY());
			}
		}

		// Handle custom tab names
		if (!config.enableTabNames())
		{
			return;
		}

		Widget tabContainer = client.getWidget(12, 10);
		if (tabContainer != null)
		{
			Widget[] children = tabContainer.getDynamicChildren();
			if (children != null)
			{
				String[] tabNames = {
					config.tab1Name(),
					config.tab2Name(),
					config.tab3Name(),
					config.tab4Name(),
					config.tab5Name(),
					config.tab6Name(),
					config.tab7Name(),
					config.tab8Name(),
					config.tab9Name()
				};

				Color[] tabColors = {
					config.tab1Color(),
					config.tab2Color(),
					config.tab3Color(),
					config.tab4Color(),
					config.tab5Color(),
					config.tab6Color(),
					config.tab7Color(),
					config.tab8Color(),
					config.tab9Color()
				};

				// Tab icons are at indices 11-19 (tabs 1-9)
				for (int i = 0; i < 9; i++)
				{
					int childIndex = 11 + i;
					if (childIndex < children.length && children[childIndex] != null)
					{
						String customName = tabNames[i];
						if (!customName.isEmpty())
						{
							String hexColor = String.format("%06x", tabColors[i].getRGB() & 0xFFFFFF);
							children[childIndex].setName("<col=" + hexColor + ">" + customName + "</col>");
						}
					}
				}
			}
		}
	}

	@Provides
	BankTweaksConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankTweaksConfig.class);
	}
}
