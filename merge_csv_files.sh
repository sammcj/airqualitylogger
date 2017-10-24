#!/bin/bash
OutFileName="merged_data.csv"             # Fix the output name
echo "Merging *.csv in the current directory to ${OutFileName}"
i=0                                       # Reset a counter
for filename in ./*.csv; do 
 if [ "$filename"  != "$OutFileName" ] ;  # Avoid recursion 
 then 
   if [[ $i -eq 0 ]] ; then 
      head -1  $filename >   $OutFileName # Copy header if it is the first file
   fi
   tail -n +2  $filename >>  $OutFileName # Append from the 2nd line each file
   i=$(( $i + 1 ))                        # Increase the counter
 fi
done
echo "Done!"
