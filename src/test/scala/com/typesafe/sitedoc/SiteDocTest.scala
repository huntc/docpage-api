package com.typesafe.sitedoc

import scala.concurrent.Future

object PlaySite extends SiteDoc {

  override def versions: Future[Seq[Version]] = ???

  override def page(version: Version, path: Path): Future[(Title, Body)] = ???

  override def toc(version: Version): Future[TOC] = ???
}

object Doco {
  //} extends Controller {

  private def privateHelperFunctionThatMatchesPathAndTree(toc: TOC, path: String): Map[String, String] = ???

  def page(version: String, path: String) = {
    for {
      toc: SiteDoc <- PlaySite.toc(version)
      (title, html) <- PlaySite.page(version, path)
      localTree <- privateHelperFunctionThatMatchesPathAndTree(toc, path)
    } yield "" //Ok (doco.view(localTree, title, html))
  }

}