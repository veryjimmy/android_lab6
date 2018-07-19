修改 Lab 5 的程式，在三個 Activity 切換時，使用 Animated Transition 來進行切換。在按下「 BMI 」、「 說明 」、「 估算身高 」時畫面會左右移動到下一個頁面。

其餘功能皆與 Lab 5 相同
如下圖所示：

![image](https://github.com/veryjimmy/android_lab5/blob/master/example1.png)

![image](https://github.com/veryjimmy/android_lab5/blob/master/example2.png)

功能如下：

#### 1. 
	Activity 1：
	a. 是程式進入的主 Activity 。用來計算估計的身高。
	b. 在程式開始時，判斷 Bundle 的內容是否為 null 。如果不是 null ，就需要將 Bundle 內的值還原到各個變數。
	c. 有兩個 Button ，一個用來跳轉到 BMI 計算的頁面，一個用來跳轉到說明的頁面。在跳轉到 BMI 計算的頁面時，需要使用 explicit intent 的方式以 startActivity(intent) 傳遞估算身高的參數到 BMI 計算頁面。
	d. 有四個 TextView ，分別顯示:「 膝長 」、「 年齡 」、「 估算身高 」、計算結果。
	e. 有兩個 EditText ，分別輸入相對應的實數值，初始值為 0 。
	f. 有兩個 RadioButton ，用來決定性別。
#### 2. 
	Activity 2：
	a. 用來計算BMI。
	b. 有兩個 Button ，一個用來跳轉到身高計算的頁面，一個用來跳轉到說明的頁面。
	c. 有四個 TextView ，分別顯示:「 身高 」、「 體重 」、「 身高 」、「 BMI 」、BMI 的計算結果，以及按照 BMI 的內容，顯示身體狀況。
	d. 有兩個 EditText ，分別輸入相對應的實數值，初始值為 0 。
	e. 有兩個 RadioButton ，用來決定目前的 BMI 身高的輸入，是自行輸入還是使用估算值。初始值自訂。
#### 3. 
	Activity 3：
	a. 有四個 Button ，一個用來跳轉到身高計算的頁面，一個用來跳轉到 BMI 計算的頁面表，一個用來將所有的輸入重設成初始值，最後一個用來結束本程式。
	b. 一個 TextView ，用來說明作者是誰。
#### 4. 
	每個頁面在離開時，要用 Bundle 保留 EditText 與 RadioButton 的狀態。下一次回來執行時可以還原。

<br/>

身高及 BMI 計算公式如下圖所示：

![image](https://github.com/veryjimmy/android_lab2/blob/master/formula.png)