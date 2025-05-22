// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract HelloWorld {
    event log_string(string log);

    function sayHello() public {
        emit log_string("Hello World!");
    }
}
