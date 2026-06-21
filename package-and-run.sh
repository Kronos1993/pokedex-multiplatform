#!/bin/bash
set -e

echo "📦 Empaquetando..."
./gradlew :desktopApp:createDistributable

APP_PATH=$(find desktopApp/build/compose/binaries -name "*.app" -maxdepth 5)

echo "🔓 Quitando cuarentena de $APP_PATH"
xattr -cr "$APP_PATH"

echo "🚀 Abriendo..."
open "$APP_PATH"
