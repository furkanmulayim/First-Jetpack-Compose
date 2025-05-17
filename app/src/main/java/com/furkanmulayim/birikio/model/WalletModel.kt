package com.furkanmulayim.birikio.model


data class WalletModel(
    /**Cüzdan LİSTESİ İÇİN*/

    val id: Int,

    val name: String,
    /**  Maaşım / Alınacak / Verildi  */

    val count: String,
    /** 300 Tl */

    val date: String,
    /** 300 Tl */

    val isBuyed: Boolean,
    /** Satış? - Alış? */

    val category: String,
    /** todo enum class ile eşleştirilecek!*/

    val notes: String?,
    /** yatırım yapan kullanıcı için opsiyonel*/
)
