package com.gymshark.hits.utils

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals


class ParseElementsTest {
    @Test
    fun testCompanionObject() {
val ex ="<p><strong>JUST ADD ENERGY</strong></p>\n" +
        "<p><br data-mce-fragment=\"1\">Power your performance with the Energy Seamless Leggings. Fully functional and fully shape-enhancing, these gym leggings help you through cardio and weights alike with support and confidence.\uFEFF</p>\n" +
        "<p> </p>\n" +
        "<p><strong>Take care:</strong> this product is delicate, so please take appropriate care when wearing and washing</p>\n" +
        "<p> </p>\n" +
        "<p><br data-mce-fragment=\"1\">- High-waisted fit<br data-mce-fragment=\"1\">- Eyelet detailing<br data-mce-fragment=\"1\">- Glute contouring with mesh structures<br data-mce-fragment=\"1\">- Ribbed waistband<br data-mce-fragment=\"1\">- Full length<br data-mce-fragment=\"1\">- Heat-sealed Gymshark logo to hip and back waistband<br data-mce-fragment=\"1\">- 93% Nylon, 7% Elastane<br data-mce-fragment=\"1\">- We've cut down on our use of swing tags, so this product comes without one<br>- Model is <meta charset=\"utf-8\"><span data-usefontface=\"true\" data-contrast=\"none\" class=\"TextRun SCXP124629587 BCX0\" lang=\"EN-GB\" data-mce-fragment=\"1\" xml:lang=\"EN-GB\"><span class=\"NormalTextRun SCXP124629587 BCX0\" data-mce-fragment=\"1\">5'9\" and wears a size XS</span></span><span class=\"EOP SCXP124629587 BCX0\" data-mce-fragment=\"1\">\u200B</span><br>- SKU: B1A2C-NBBB</p>"
        val element: Element =
            Jsoup.parse(""" <strong data-mce-fragment="1">RUN WITH IT</strong> """).body()
        val output = "<b>RUN WITH IT</b>"

        val element1: Element = Jsoup.parse(""" <p data-mce-fragment="1">RUN WITH IT</p><p data-mce-fragment="1">RUN WITH IT</p> """).body()
        val output1 = "RUN WITH IT\nRUN WITH IT"

        val element2: Element = Jsoup.parse("""<br data-mce-fragment="1">- Heat-sealed Gymshark logo to hip and back waistband""").body()
        val output2 = "- Heat-sealed Gymshark logo to hip and back waistband"

////
////        // Call a method that calls the companion object method
////        // You can verify stubMethod() is called
//        testObject.parseElement(element)

        assertEquals(output, ParseElements().parseElement(element))
        assertEquals(output1, ParseElements().parseElement(element1))
        assertEquals(output2, ParseElements().parseElement(element2))

    }

}