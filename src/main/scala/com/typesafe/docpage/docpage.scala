package com.typesafe.docpage

import scala.concurrent.Future

trait DocPage {
  type Version = String
  type Title = String
  type Body = String
  type Path = String
  type TOC = Seq[(Title, Either[TOC2, Path])]
  type TOC2 = Seq[(Title, Either[TOC3, Path])]
  type TOC3 = Seq[(Title, Path)]

  def versions: Seq[Version]

  def page(version: Version, path: Path): Future[(Title, Body)]

  def toc(version: Version): Future[TOC]
}


object PlayPage extends DocPage {
  override def versions: Seq[PlayPage.Version] = ???

  override def page(version: PlayPage.Version, path: PlayPage.Path): Future[(PlayPage.Title, PlayPage.Body)] = ???

  override def toc(version: PlayPage.Version): Future[PlayPage.TOC] = ???
}

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