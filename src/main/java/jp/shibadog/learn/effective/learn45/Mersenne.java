package jp.shibadog.learn.effective.learn45;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Mersenne {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger ONE = BigInteger.valueOf(1);

    public void run() {
        run1();
        // run2();
    }

    public Stream<BigInteger> primes() {
        // 遅延実行で、 `next()` すると `BigInteger::nextProbablePrime` を `apply` する
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public void run1() {

        primes()
            // 2<sup>p</sup> - 1
            .map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
            // 素数っぽいかどうかチェック
            .filter(mersenne -> mersenne.isProbablePrime(50))
            .limit(20)
            .map(BigInteger::toString)
            .forEach(log::info);

        // これだけだと、メルセンヌ素数20個が出力される。
    }

    public void run2() {
        // メルセンヌ素数20個に指数を付けてあげる（もともとの値p）

        primes()
            // 2<sup>p</sup> - 1
            .map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
            // 素数っぽいかどうかチェック
            .filter(mersenne -> mersenne.isProbablePrime(50))
            .limit(20)
            .forEach(mp -> log.info(mp.bitLength() + ": " + mp));
    }
}