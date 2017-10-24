# AirQualityLogger

For use with the "HT2000" Air quality monitors commonly found on eBay.

## Usage

1. Requires Java (**Disgusting, I know** - I was lazy as it had the quickest USB HID library for me to interface with).
1. Download the [latest release](https://github.com/sammcj/airqualitylogger/releases/latest), unzip and run:
1. Start the logger:
  ```shell
  ~# java -jar ht2000.jar
  ```

* You can merge multiple data files logged to csv with:
  ```shell
  ~# ./merge_csv_files.sh
    Merging *.csv in the current directory to merged_data.csv
    Done!
  ```

* You can import this data to a sqlite database:
  ```sql
  ~# sqlite3 airqualitydata.db
    CREATE TABLE "airmonitor" ( `Date` TEXT, `Time` TEXT, `Temperature` REAL, `Humidity` REAL, `Co2PPM` INTEGER );
    .mode csv
    .import merged_data.csv
  ```

## Example Output

```shell
Taking measurements every 1 minute and saving to/Users/samm/Desktop/airmonitor-2017-10-20-11-00.csv, press enter to end
Timestamp: 2017-10-20 21:00:53 Temperature: 24.4 Humidity: 42.2 Co2 PPM: 653
Timestamp: 2017-10-20 21:01:53 Temperature: 24.4 Humidity: 42.2 Co2 PPM: 655
Timestamp: 2017-10-20 21:02:53 Temperature: 24.5 Humidity: 42.2 Co2 PPM: 662
```

![](https://github.com/sammcj/airqualitylogger/blob/master/Example%20CSV%20Output.jpg?raw=true)

## Example graph from the data

![](https://github.com/sammcj/airqualitylogger/blob/master/co2%20graph.jpg?raw=true)

## Merging CSV files

I've created a simple bash script to merge all CSV files in the current directory and output them as `merged_data.csv`.

## Contributions

Thanks to @eschava for his 'HT2000-java' implementation, (his GUI to the HT2000 can be found under the `gui/` directory)

## Example HT2000 Devices

![](https://github.com/sammcj/airqualitylogger/blob/master/HT2000-1.jpg?raw=true)
![](https://github.com/sammcj/airqualitylogger/blob/master/HT2000-2.jpg?raw=true)
