package com.typesafe

package object sitedoc {
  type RecentlyOrderedSeq[T] = Seq[T]
  type Version = String
  type Title = String
  type Body = String
  type Path = String

  sealed trait DocTree

  case class TOC(children: Seq[DocTree])

  case class Page(title: Title, path: Path)

}
