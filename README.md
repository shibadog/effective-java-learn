# 項目45 ストリームを注意して使う

ストリームを使う場合は、使い過ぎに注意する。
* *ストリームの乱用はプログラムの理解や保守を難しくします。* - p207
* *明示的な型がないので、ラムダのパラメータを注意深く命名することは、ストリームパイプラインの可読性にとっては重要です。* - p208
    * パラメータの変数名をわかりやすくしないと訳が分からなくなりやすい。
* *ストリームパイプラインの可読性にとって、ヘルパーメソッドを使うことはループのコードよりも重要です。* - p208
    * 型情報や一時変数が抜けていることによって、情報が少ないため。
* *`char`値を処理するためにストリームを使うのは控える*べき - p208
    * charがint値になってしまう。。。
* *ストリームを使うことに意味がある場合にだけ、既存のコードをストリームを使うようにリファクタリングしたり、新たなコードでストリームを使ったりしてください* - p209

ストリームではできないこと
* コードブロックからは、スコープ内のローカル変数を読み出したり修正したりできる。ラムダからは、finalの変数か実質的finalの変数を読み出せるだけでローカル変数を修正できません。
* コードブロックからは、それを含むメソッドからreturnしたり、それを含むループからbreakやcontinueを行ったり、あるいはメソッドがスローすると宣言している例外をスローしたりできます。

ストリームに適した処理
* 均一に要素のシーケンスを変換する
* 要素のシーケンスをフィルタする
* 単一の操作（例えば、加算する、結合する、最小値を計算する）を使って要素のシーケンスをまとめる
* 恐らく何かの共通の属性でグループ化して、要素のシーケンスをコレクションに蓄積する
* 何らかの条件を満足する要素を要素のシーケンスから検索する。

困難な点の解決案たち

1. 中間操作間でのデータ参照
    1. ペアオブジェクトを使う
    2. マッピングを逆にする





