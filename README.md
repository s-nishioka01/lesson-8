# 第8回講義課題
## 課題の内容 
以下の要件を満たすアプリケーションを作成する。

## 要件  
- ログイン/ログアウトができる
- CRUD機能を実装している
- 画面から年月日それぞれに対する加減算値を登録できる
- 画面から年月日を入力できる
- 登録した加減算値を元に計算処理が実行され、結果が画面に表示される

## アプリケーションの内容
- 日付計算アプリ
- トップページで基準の日付を選択し、データベースに登録されている計算式を選んで計算できる。
- 計算式リストページでデータベースに登録してある計算式を一覧で確認可能。
- 計算式の新規作成、編集、削除が可能。
- Spring Securityによるログイン機能を実装。

## 構成要件
Java 17  
Gradle 7.4.1  
Spring Boot 2.6.7  
Docker Desktop 4.8.7  
Docker Compose 2.5.0  
MySQL 8.0  
MyBatis Spring Boot Starter 2.2.2  

## 主な機能
- ログイン
ユーザーネームとパスワードを入力し、ログインボタンを押すとログインできる。各ページにあるログアウトボタンを押す事でログアウトできる。  
![lesson8login](https://user-images.githubusercontent.com/103230014/173575686-f094fccc-a060-4203-9790-f44531450f37.gif)  

- 計算ページ  
基準となる日付を選択肢、プルダウンメニューから計算式を選択して計算ボタンを押すと計算結果ページに計算結果が表示される。  
![lesson8calculate](https://user-images.githubusercontent.com/103230014/173576008-0cf7eccf-d313-441d-b57d-23334e7c0945.gif)  

- 計算式リスト  
データベースに登録されている計算式が一覧で表示される。  

- 新規登録  
計算式名を入力し、計算値の要素をそれぞれ選択し、登録ボタンを押すと計算式が新しく計算式リストに追加される。  
![lesson8new](https://user-images.githubusercontent.com/103230014/173576429-86641957-326c-48f5-a0f0-4c424e54eaae.gif)  

- 編集  
計算式名と計算値を変更し、登録ボタンを押すと計算式が更新される。  
![lesson8edit](https://user-images.githubusercontent.com/103230014/173576607-f208c015-e1fc-408b-b424-f8545448ff12.gif)

- 削除  
計算式を削除できる。  
![lesson8delete](https://user-images.githubusercontent.com/103230014/173576713-1556e34c-3491-4bdf-aa73-07380db0c21b.gif)  

