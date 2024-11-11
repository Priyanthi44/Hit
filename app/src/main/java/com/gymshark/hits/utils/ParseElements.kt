package com.gymshark.hits.utils

import org.jsoup.nodes.Element

class ParseElements {


    fun parseElement(element: Element): String {

        val builder = StringBuilder()
        element.children().forEach { child ->
            if (child.text().trim().startsWith("-") ){
                builder.append("\n").append(child.text()).append("\n")
            }else {
                when (child.tagName()) {
                    "p" -> builder.append(child.text()).append("\n")
                    "strong" -> builder.append("<b>").append(child.text()).append("</b>")
                        .append("\n")

                    "br" -> builder.append("\n")
                    else -> builder.append(child.text())
                }
            }


        }
        return builder.toString().trim()
    }
}