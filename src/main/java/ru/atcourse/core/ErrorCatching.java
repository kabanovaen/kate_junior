package ru.atcourse.core;

import java.rmi.UnexpectedException;

class ErrorCatching {

  Exception doError(){throw new InternalError("This is InternalError!");}

  Exception doException() throws UnexpectedException {throw new UnexpectedException("This is UnexpectedException!");}
}
