package com.mvatech.ftrujillo.retailapp.features.shop.data.repository

import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCategory
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCollection
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.NewArrival
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.Promotion
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.random.Random

class MockDataGenerator {
    fun getNewArrivalList(size: Int): List<NewArrival> {
        val list = mutableListOf<NewArrival>()
        val imageList = generateImageList(size)
        for (i in 0 until size) {
            if(i %2 == 0){
                list.add(
                    NewArrival(
                        i.toLong(), imageList[i],
                        "Vacation Button-Up", generateRandomIntPriceFromRange(50,70),
                        generateRandomIntPriceFromRange(40,49), "Mens",
                        "Getaway Essentials",
                        "Trend Edit", "https://www.abercrombie.com/shop/us"
                    )
                )
            } else {
                list.add(
                    NewArrival(
                        i.toLong(), imageList[i],
                        "Vacation Button-Up", generateRandomFloatPriceFromRange(70,100),
                        generateRandomFloatPriceFromRange(50,60), "Mens",
                        "Getaway Essentials",
                        "Trend Edit", "https://www.abercrombie.com/shop/us"
                    )
                )
            }
        }
        return list
    }

    private fun generateImageList(size: Int): List<String> {
        val mutableList = mutableListOf<String>()


        var count = 0
        for (i in 0 until size) {
            if (count == newArrivalPhotos.size) count = 0
            mutableList.add(newArrivalPhotos[count])
            count++
        }
        return mutableList
    }

    private fun generateRandomIntPriceFromRange(low: Int, up: Int): BigDecimal{
       return BigDecimal(Random.nextInt(low, up)).setScale(2, RoundingMode.FLOOR)
    }

    private fun generateRandomFloatPriceFromRange(low: Int, up: Int): BigDecimal{
        return BigDecimal(Random.nextDouble(low.toDouble(), up.toDouble())).setScale(2, RoundingMode.FLOOR)
    }
    private val newArrivalPhotos = listOf(
        "https://bau0ca.bn.files.1drv.com/y4mr211En_Ue6Myu7ERqyeFBLvC0l0fUuVaApZqe9seNEe4EQCHCx847R9OiP3I5y9YXQUBrlmzEDdnACs-Phrj9Swajc_Ekcm3i-fdXxVOgmFqtNTgAhQuETCdYq4nr1g2QieAPsbI7PV7aE1I84uiJbdWSisD13wOjZWIJGx1-Zd7XL5REz1AlrnwBheKKFvpT5IGsPziqvWK2WZaMCNp5g?width=432&height=540&cropmode=none",
        "https://cwt32a.bn.files.1drv.com/y4mmKAG6szDWNaahMW18DUwdvLpEoOklhllV0ElcCKaLVqZY_8YJ_3zqmoSzQIlOTOhWaNzafwyBxiis9s9qsB8IgIErj2UoeS1ImojrxSLlztbOBM7m4rahD_w3vNh-VN2z6PXS1Yjn1OxBzxFk_39810IUOeV0SY8uUZ1mxrNGu27WlXUs6JBvCN_1L8FKj5p-YLNfXZd6hSD4C3dbTcWGw?width=432&height=540&cropmode=none",
        "https://cat32a.bn.files.1drv.com/y4mw29-mWtKmVv-oCqfwiNspmr_nl6sIgwMVoHb-7qw_aDxe4zBDEx-nbhHddPR-83-FtUfOB0dJnctmz_YoX_QlC_W-39chpDipQdLzLoJ7g68UfDhf9_yfyOCZYDu53YplSKy1_kOf1K8z3had56FZvS27OPIgowq78DdJn8oixXGNKFUMOiUyd0yq7SNQsU-U6UJuD9ghPmBbTmL5FOjfA?width=432&height=540&cropmode=none",
        "https://bqu0ca.bn.files.1drv.com/y4mDfw1-fk3HvCmz7070D0DkuJADwQ7ACQ5ouTcONpUEmdhCZkcPNHXDx7Tua-mmCM42xLM16Mxj0Iv4UdSwha3YeD8PKxYufOjRJjvKAzv9l3KGCY308BDxKT8ErLb-0bBQi0qbmqITRZ3hEJHTAX0iEBJSzfGeNa2y_XP-uNvHRrvmrW2oZ-de0KgccthbVTvv9xGcINvxm2r0dH5LoFsjQ?width=432&height=540&cropmode=none"
    )


    fun getClothingCategoryList(): List<ClothingCategory> {
        val list = mutableListOf<ClothingCategory>()
        list.add(
            ClothingCategory(
                "Tops",
                "https://cwt32a.bn.files.1drv.com/y4mmKAG6szDWNaahMW18DUwdvLpEoOklhllV0ElcCKaLVqZY_8YJ_3zqmoSzQIlOTOhWaNzafwyBxiis9s9qsB8IgIErj2UoeS1ImojrxSLlztbOBM7m4rahD_w3vNh-VN2z6PXS1Yjn1OxBzxFk_39810IUOeV0SY8uUZ1mxrNGu27WlXUs6JBvCN_1L8FKj5p-YLNfXZd6hSD4C3dbTcWGw?width=432&height=540&cropmode=none"
            )
        )
        list.add(
            ClothingCategory(
                "Jackets & Coats",
                "https://bqt32a.bn.files.1drv.com/y4mxOcrBg8c37GkqD99nwTY4jgpNZnmbSgE1Dj0_r1Qm5iX-8Lh3id0p2Vc797dXRIvufHO56HeusfKf66aG4qxUpdgrZlxGjmqXNAoLKaEsC_VhTFSEVU2cRSSFc7PqczrMK-yKyhn512KqZ0Xu5xkptwpfrPtO0buIULpUIpqwuRZ_gBFK4YzvxGoxTiDfAoaFLCW-g0l0xAZasVMLODhDg?width=432&height=540&cropmode=none"
            )
        )
        list.add(
            ClothingCategory(
                "Bottoms",
                "https://eau0ca.bn.files.1drv.com/y4mJYEEVObZdACBghLpSVPJ1jV-zsC0iYwlVciZ7MJgXw2tbzKoiaJXR6FMJqxSkgOCcsK1hVNpODEP1WP5hnh-RApT9WpRgu4EURShaoaG-aoXFZwPzfn_tMRt2_9IAduJv1ulguFAs50Dk1CiTyjcljS8QOwedB963RKG6IXhmabAejetM3DnnU4Wyt_fLIS3mpijtdUZFWrvizDR2hizIg?width=432&height=540&cropmode=none"
            )
        )
        list.add(
            ClothingCategory(
                "Clearance",
                "https://bwu0ca.bn.files.1drv.com/y4mSTM6xcWbDnoSgdM8j3ibYFihpWSXwIduDNnAIy5Xcedy5eZnT0ZooAyDHaM4rHUVlLlLn8P21aeHS80Hau-T-9VpIgGWwD0Odd-2lYRTlbjSYLGbqFrhFVLRtRYWFg99rENvhklr7pQhl1hUp6smcbE_CBMkPWq9k61juNJY7qJHozrKG3BrbuaWAUnPljemFKp3leSosW1BhE96AOq3bg?width=432&height=540&cropmode=none",
                true
            )
        )

        return list
    }

    fun getCollectionList(): List<ClothingCollection> {
        val list = mutableListOf<ClothingCollection>()
        list.add(
            ClothingCollection(
                "GETAWAY",
                "https://bat32a.bn.files.1drv.com/y4mdA917BAO-m7MWvPzSElyrqIkqGQIb_HYfazI9rjyPaoyfb9b7Bf9ZilUTn9p5aOS10z3F1PTooaw2NndOH9X64v3vnQZ87pevSDQjOZlA3ECYNBEsCONUIanHVdL1Q025PO1Lct1iVzV4rdxQcGjp-Y-KkIiLoxJDxu3qk7zFFFCORIddsH_DP_ls1MlyGdfKBzCPL-msQ2TAUEOEJXu5w?width=432&height=540&cropmode=none"
            )
        )
        list.add(
            ClothingCollection(
                "OUR COLLECTION",
                "https://bqu0ca.bn.files.1drv.com/y4mDfw1-fk3HvCmz7070D0DkuJADwQ7ACQ5ouTcONpUEmdhCZkcPNHXDx7Tua-mmCM42xLM16Mxj0Iv4UdSwha3YeD8PKxYufOjRJjvKAzv9l3KGCY308BDxKT8ErLb-0bBQi0qbmqITRZ3hEJHTAX0iEBJSzfGeNa2y_XP-uNvHRrvmrW2oZ-de0KgccthbVTvv9xGcINvxm2r0dH5LoFsjQ?width=432&height=540&cropmode=none"
            )
        )
        list.add(
            ClothingCollection(
                "SIMPLE",
                "https://eat32a.bn.files.1drv.com/y4macJmwNiNaO6-XUj9PDqUc0UkxYgW8HU2GyjTPY4iLmBNVZpVB-80XKeJDga81kwbA6ZkWFRxCIaymfQU0LPRd_6AafTC2VGzMGtdinOPv1gsUP96pZpUAHDMCXi_rmgYA9rdhTZzkoOtqZLH3EqI6q3aKbsDAIcK1VOkSPpouKvb9367zH4qXjtztIP460jKwxfHdIOjI3d37kf8UAOcSQ?width=432&height=540&cropmode=none"
            )
        )

        return list
    }

    fun preparePromotionList(promotions: List<Promotion>): List<Promotion> {
        var count = 0
        for (i in 0 until promotions.size) {
            if (count == bannerList.size) count = 0
            promotions[i].backgroundImage = bannerList[count]
            count++
        }
        return promotions
    }

    private val bannerList = listOf(
        "https://eqting.bn.files.1drv.com/y4mKpBBiIM5ZBaBpOWCCQpuF72wni7zIWWKs3l3wRKHfBsEiadXyEsdGXQahsy1rO1YpwnI6RkoaDAJe1HeueiXVAwkCBKEGarVOG1kwQs_8-KAYrsAkVemCBkMdZLKz50TfpyAXHFcz2cXJcPmDdf1R-TGWxEwJlIsKzdZYT3iyPL9niQdY78F08AyGOe1SabTWl06-A0ZcyAvAdSI3iQg_g?width=904&height=505&cropmode=none",
        "https://cau7tw.bn.files.1drv.com/y4mrnodBdSRALAMUolj6Jyqs0ht1WQ5pTwpTLeb3PqtNLYdP8maoYTIG-0XWnvpQ8eHSMabu7OfUuWjNoOwD1-pj7LM-vzFa5494NXKoZHla8UWmVcjaBh8nPWmIa73h7X6HMEOWR06K_f-iHQc_i2dopn1IjeyQ-LF4iry3KL_hiQMbc8sFoJQYNmP1dfR_9ny_ekftO0LZ9unsFWGybsaug?width=904&height=505&cropmode=none",
        "https://cqu7tw.bn.files.1drv.com/y4mdFlKM-IRIjcncAk5zOm9YhCiXxlONFi5e7JlX6WlERSgTUEKuom6QFIg7x9h2-ZMVcNFjEj-g6CcGeNvuLvbgMuWonX4yubl0kj6fXLX8F6VMiwM1FBpoj5VyLe3pt9iZ3jmDgEzk6IkhgNmrHB3T3n8zhbPG6zbgqUyh0M1UNgDJFXxwlczlEShaLAz3Jkb1L5CEP1vY95aZrYFdutrog?width=904&height=505&cropmode=none",
        "https://cgu7tw.bn.files.1drv.com/y4mLAP8wqv0tQ04_cV_P5sstgHqxd6PNa-YCX2k5ulJnw0dcpyphssRjosSTiesJUckHloyb7DbmPzSGAfuKR80V2PAnJQzUHV1EVzEvUxtluhsrn8-ERdzDRZrTZavruS48Xzm366Wdmjn1o1flY6ACTcz89_hMA9oUV6N-h6eqKR4LGDZakun8ME2Ms6qMu0ypLd85ZPJ3qW3CLe920fhrQ?width=904&height=505&cropmode=none",
        "https://cwu7tw.bn.files.1drv.com/y4m5b7K1OFHGVuB5zGxK_RYnPLHm-Qc3Bn_GfxxDjAPDe0fHzym0L9Qg5lNG9hieVtcTt9aAou1EEHhiu6u1_2GIgJy5A_59Oc7jIEfsjEGzceD_MfKZtM3eJbPezwhK0MBjtyQaiOazqAQupPFkN7mi-R5egOEQLbucQyUPEa6x5fjOaKGFcyLuJDP-0M4dMlt6iyRKb-3G2n9yCqGiJq8XQ?width=904&height=505&cropmode=none"
    )
}