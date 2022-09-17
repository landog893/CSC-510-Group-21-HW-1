
# Installation

This document covers the steps necessary to download and run.

## Prerequisites

You will need the following programs and packages installed on your local machine.

Programs:

* Java Development Kit
* Git

## Setup
   1.Clone the repo to a local folder:

    git clone https://github.com/landog893/CSC-510-Group-21-HW-1.git


 2.Navigate to the folder:

    cd ./Group21HW/src

 3.Compile all java files

    javac *.java

 4.Run the code

    java -Xmx100m com.group21.csc510.csv.lua.Lua -e All

## Results
You should get the results same as following:

```
-----------------------------------
!!!!!!	CRASH	BAD	false

-----------------------------------
!!!!!!	FAIL	LIST	true

-----------------------------------

Examples lua csv -e ...
	ALL
	BAD
	LIST
	LS
	bignum
	csv
	data
	num
	stats
	sym
	the
!!!!!!	PASS	LS	true

-----------------------------------
{1 28 49 50 56 85 86 156 208 237 294 327 444 459 461 485 490 503 
 546 618 653 712 723 727 770 801 849 915 928 941 967 987}
!!!!!!	PASS	bignum	true

-----------------------------------
{Clndrs Volume Hp: Lbs- Acc+ Model origin Mpg+}
{8 304 193 4732 18.5 70 1 10}
{8 360 215 4615 14 70 1 10}
{8 307 200 4376 15 70 1 10}
{8 318 210 4382 13.5 70 1 10}
{8 429 208 4633 11 72 1 10}
{8 400 150 4997 14 73 1 10}
{8 350 180 3664 11 73 1 10}
{8 383 180 4955 11.5 71 1 10}
{8 350 160 4456 13.5 72 1 10}
!!!!!!	PASS	csv	true

-----------------------------------
{:at 4 :hi 5140 :isSorted false :lo 1613 :n 398 :name Lbs- :w -1}
{:at 5 :hi 24.8 :isSorted false :lo 8 :n 398 :name Acc+ :w 1}
{:at 8 :hi 50 :isSorted false :lo 10 :n 398 :name Mpg+ :w 1}
!!!!!!	PASS	data	true

-----------------------------------
50	31.007751937984
!!!!!!	PASS	num	true

-----------------------------------
xmid	{:Clndrs 4.0 :Model 76.0 :Volume 146.0 :origin 1.0}
xdiv	{:Clndrs 1.55 :Model 3.876 :Volume 100.775 :origin 0.775}
ymid	{:Acc+ 15.5 :Lbs- 2800.0 :Mpg+ 20.0}
ydiv	{:Acc+ 2.713 :Lbs- 887.209 :Mpg+ 7.752}
!!!!!!	PASS	stats	true

-----------------------------------
{:div 1.378 :mid a}
!!!!!!	PASS	sym	true

-----------------------------------
{:dump false :eg ALL :file ../data/auto93.csv :help false :nums 512 :seed 10019 :seperator ,}
!!!!!!	PASS	the	true
!!!!!!	PASS	ALL	true
```
