#!/bin/bash
sudo kill -9 $(ps -ef | grep actuator_led.py | grep -v grep | awk '{print $2}')
