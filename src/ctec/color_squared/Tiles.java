package ctec.color_squared;

import android.graphics.Color;

public class Tiles
{
	private boolean oneHotButton;
	private boolean twoHotButton;
	private boolean threeHotButton;
	private boolean fourHotButton ;
	private boolean fiveHotButton;
	private boolean sixHotButton ;
	private boolean sevenHotButton;
	private boolean eightHotButton;
	private boolean nineHotButton;

	private Color oneColor;
	private Color twoColor;
	private Color threeColor;
	private Color fourColor;
	private Color fiveColor;
	private Color sixColor;
	private Color sevenColor;
	private Color eightColor;
	private Color nineColor;

	public void tiles()
	{
		this.oneHotButton = false;
		this.twoHotButton = false;
		this.threeHotButton = false;
		this.fourHotButton = false;
		this.fiveHotButton = false;
		this.sixHotButton = false;
		this.sevenHotButton = false;
		this.eightHotButton = false;
		this.nineHotButton = false;
		this.oneColor = null;
		this.twoColor = null;
		this.threeColor = null;
		this.fourColor = null;
		this.fiveColor = null;
		this.sixColor = null;
		this.sevenColor = null;
		this.eightColor = null;
		this.nineColor = null;
	}

	public void setOneColor(Color oneColor)
	{
		this.oneColor = oneColor;
	}

	public void setTwoColor(Color twoColor)
	{
		this.twoColor = twoColor;
	}

	public void setThreeColor(Color threeColor)
	{
		this.threeColor = threeColor;
	}

	public void setFourColor(Color fourColor)
	{
		this.fourColor = fourColor;
	}

	public void setFiveColor(Color fiveColor)
	{
		this.fiveColor = fiveColor;
	}

	public void setSixColor(Color sixColor)
	{
		this.sixColor = sixColor;
	}

	public void setSevenColor(Color sevenColor)
	{
		this.sevenColor = sevenColor;
	}

	public void setEightColor(Color eightColor)
	{
		this.eightColor = eightColor;
	}

	public void setNineColor(Color nineColor)
	{
		this.nineColor = nineColor;
	}

	public Color getOneColor()
	{
		return oneColor;
	}

	public Color getTwoColor()
	{
		return twoColor;
	}

	public Color getThreeColor()
	{
		return threeColor;
	}

	public Color getFourColor()
	{
		return fourColor;
	}

	public Color getFiveColor()
	{
		return fiveColor;
	}

	public Color getSixColor()
	{
		return sixColor;
	}

	public Color getSevenColor()
	{
		return sevenColor;
	}

	public Color getEightColor()
	{
		return eightColor;
	}

	public Color getNineColor()
	{
		return nineColor;
	}

	public boolean isOneHotButton()
	{
		return oneHotButton;
	}

	public boolean isTwoHotButton()
	{
		return twoHotButton;
	}

	public boolean isThreeHotButton()
	{
		return threeHotButton;
	}

	public boolean isFourHotButton()
	{
		return fourHotButton;
	}

	public boolean isFiveHotButton()
	{
		return fiveHotButton;
	}

	public boolean isSixHotButton()
	{
		return sixHotButton;
	}

	public boolean isSevenHotButton()
	{
		return sevenHotButton;
	}

	public boolean isEightHotButton()
	{
		return eightHotButton;
	}

	public boolean isNineHotButton()
	{
		return nineHotButton;
	}

	public void setOneHotButton(boolean oneHotButton)
	{
		this.oneHotButton = oneHotButton;
	}

	public void setTwoHotButton(boolean twoHotButton)
	{
		this.twoHotButton = twoHotButton;
	}

	public void setThreeHotButton(boolean threeHotButton)
	{
		this.threeHotButton = threeHotButton;
	}

	public void setFourHotButton(boolean fourHotButton)
	{
		this.fourHotButton = fourHotButton;
	}

	public void setFiveHotButton(boolean fiveHotButton)
	{
		this.fiveHotButton = fiveHotButton;
	}

	public void setSixHotButton(boolean sixHotButton)
	{
		this.sixHotButton = sixHotButton;
	}

	public void setSevenHotButton(boolean sevenHotButton)
	{
		this.sevenHotButton = sevenHotButton;
	}

	public void setEightHotButton(boolean eightHotButton)
	{
		this.eightHotButton = eightHotButton;
	}

	public void setNineHotButton(boolean nineHotButton)
	{
		this.nineHotButton = nineHotButton;
	}
}