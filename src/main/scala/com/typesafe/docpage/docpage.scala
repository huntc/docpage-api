package com.typesafe.docpage

import scala.concurrent.Future

trait DocPage {
  type Title = String
  type Body = String
  type Path = String
  type TOC = Seq[(Title, Either[TOC2, Path])]
  type TOC2 = Seq[(Title, Either[TOC3, Path])]
  type TOC3 = Seq[(Title, Path)]

  def page(version: String, path: String): Future[(Title, Body)] = ???

  def toc(version: String): Future[TOC] = ???
}


object PlayPage extends DocPage

object Doco {
  //} extends Controller {

  import PlayPage._

  private def privateHelperFunctionThatMatchesPathAndTree(toc: TOC, path: String): Map[String, String] = ???

  def page(version: String, path: String) = {
    for {
      toc <- PlayPage.toc(version)
      (title, html) <- PlayPage.page(version, path)
      localTree <- privateHelperFunctionThatMatchesPathAndTree(toc, path)
    } yield "" //Ok (doco.view(localTree, title, html))
  }

}