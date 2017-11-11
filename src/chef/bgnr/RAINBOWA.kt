package chef.bgnr

import java.util.Scanner

internal object RAINBOWA {

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val T = sc.nextInt()
        for (t in 0 until T) {
            val n = sc.nextInt()
            if(n < 13) {
                println("no")
                continue
            }
            val ar = IntArray(n, {sc.nextInt()})
            val sb = StringBuilder();
            for (i in 0..(ar.size/2)){
                if(sb.isEmpty() || sb[sb.length-1]!=Character.forDigit(ar[i], 10)){
                    sb.append(Character.forDigit(ar[i], 10))
                }
                if(ar[i]!=ar[ar.size-i-1]) break;
                println(sb)
            }
            println(if ("1234567" == sb.toString()) "yes" else "no")
        }
    }
}
