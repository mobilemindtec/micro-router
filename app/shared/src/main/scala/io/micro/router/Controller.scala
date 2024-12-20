package io.micro.router

trait Controller[Req, Resp]:

  private type Maybe = Resp | Unit

  def get(req: Req): Maybe = ()

  def post(req: Req): Maybe = ()

  def put(req: Req): Maybe = ()

  def delete(req: Req): Maybe = ()

  def head(req: Req): Maybe = ()

  def options(req: Req): Maybe = ()

  def patch(req: Req): Maybe = ()

  def handle(req: Req): Maybe = ()

trait Handler[Req, Resp]:

  // handler all methods
  def handle(req: Req): Resp
