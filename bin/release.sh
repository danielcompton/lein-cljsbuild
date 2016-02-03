#!/bin/bash
#
# Release plugin and support with lein-release. Takes the same arguments as lein release does.
# See https://github.com/technomancy/leiningen/blob/master/doc/DEPLOY.md#releasing-simplified for more details

set -e

pushd support
lein do clean, release $0
popd

pushd plugin
lein do clean, release $0
popd
