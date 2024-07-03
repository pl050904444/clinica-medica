#!/bin/bash

java -jar clinica-administrativo/target/clinica-administrativo.jar &
java -jar clinica-agendamento/target/clinica-agendamento.jar &
java -jar clinica-atendimento/target/clinica-atendimento.jar &
java -jar clinica-commons/target/clinica-commons.jar &

wait