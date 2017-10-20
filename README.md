# AirQualityLogger

For use with the "HT2000" Air quality monitors commonly found on eBay.

## Usage

1. Requires Java (**Disgusting, I know** - I was lazy as it had the quickest USB HID library for me to interface with).
1. Download the [latest release](https://github.com/sammcj/airqualitylogger/releases/latest), unzip and run:

```shell
java -jar ht2000.jar
```

## Example Output


```shell
Taking measurements every 1 minute and saving to/Users/samm/Desktop/airmonitor-2017-10-20-11-00.csv, press enter to end
Timestamp: 2017-10-20 21:00:53 Temperature: 24.4 Humidity: 42.2 Co2 PPM: 653
Timestamp: 2017-10-20 21:01:53 Temperature: 24.4 Humidity: 42.2 Co2 PPM: 655
Timestamp: 2017-10-20 21:02:53 Temperature: 24.5 Humidity: 42.2 Co2 PPM: 662
Timestamp: 2017-10-20 21:03:53 Temperature: 24.5 Humidity: 42.1 Co2 PPM: 664
Timestamp: 2017-10-20 21:04:53 Temperature: 24.5 Humidity: 42.1 Co2 PPM: 663
Timestamp: 2017-10-20 21:05:53 Temperature: 24.5 Humidity: 42.0 Co2 PPM: 665
Timestamp: 2017-10-20 21:06:53 Temperature: 24.5 Humidity: 42.0 Co2 PPM: 665
Timestamp: 2017-10-20 21:07:53 Temperature: 24.5 Humidity: 42.0 Co2 PPM: 669
Timestamp: 2017-10-20 21:08:53 Temperature: 24.5 Humidity: 41.9 Co2 PPM: 669
Timestamp: 2017-10-20 21:09:53 Temperature: 24.5 Humidity: 42.0 Co2 PPM: 671
```

## Contributions

Thanks to @eschava for his 'HT2000-java' implementation, (his GUI to the HT2000 can be found under the `gui/` directory)

## Example HT2000 Devices

![](https://github.com/sammcj/airqualitylogger/blob/master/HT2000-1.jpg?raw=true)
![](https://github.com/sammcj/airqualitylogger/blob/master/HT2000-2.jpg?raw=true)
