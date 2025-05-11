package com.furkanmulayim.birikio.model


data class InvestModel(
    /**YATIRIM LİSTESİ İÇİN*/

    val id: Int,

    val name: String,
    /**  Altın 24 ayar  */

    val count: String,
    /** 4 gram */

    val isBuyed: Boolean,
    /** Satış? - Alış? */

    val currentPrice: String,
    /**  44 fiyatı */

    val totalPrice: String,
    /**  440 tl */

    val category: String,
    /** todo enum class ile eşleştirilecek!*/

    val notes: String?,
    /** yatırım yapan kullanıcı için opsiyonel*/
)
