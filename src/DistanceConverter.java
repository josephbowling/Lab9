public class DistanceConverter extends ConverterPane {
	
	private String title = "Distance Converter";
	private String[] options = {
			"cm - centimeters",
			"km - kilometers",
			"ft - feet",
			"yd - yards"
	};
	private String fromUnit;
	private String toUnit;
	private String fromValue;
	
	public DistanceConverter() {
		setTitle(title);
		setOptions(options);
		
		button.setOnMouseClicked(event -> {
			
			fromUnit = getFromUnit();
			toUnit = getToUnit();
			fromValue = getValueFrom();
			double value;
			double meterLength;
			double result;
			try {
				value = Double.parseDouble(fromValue);
				if ((meterLength = convertToMeter(value, fromUnit)) >= 0) {
					result = convertToUnit(meterLength, toUnit);
					textOut.setText("" + df.format(result));
				} else {
					textOut.setText("Distance can't be lower than zero!");
				}
			} catch (NumberFormatException e) {
				textOut.setText("Bad number");
			}
		});
	}
	
	private double convertToMeter(double value, String fromUnit) {
		double result = 0;
		switch (fromUnit) {
		case "cm":
			result = value / 100;
			break;
		case "km":
			result = value * 1000;
			break;
		case "ft":
			result = value / 3.28084;
			break;
		case "yd":
			result = value / 1.09361;
			break;
		default:
			textOut.setText("No such Distance Unit");
		}
		return result;
	}	
	
	private double convertToUnit(double value, String toUnit) {
		double result = 0;
		switch(toUnit) {
		case "cm":
			result = value * 100;
			break;
		case "km":
			result = value / 1000;
			break;
		case "ft":
			result = value * 3.28084;
			break;
		case "yd":
			result = value * 1.09361;
			break;
		}
		return result;
	}
}