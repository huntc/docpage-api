package com.typesafe.sitedoc

import scala.concurrent.Future

trait SiteDoc {

  def versions: Future[RecentlyOrderedSeq[Version]]

  def page(version: Version, path: Path): Future[(Title, Body)]

  def toc(version: Version): Future[DocTree]
}
