import SwiftUI
import shared

@main
struct iOSApp: App {
 init() {
     Main_iosKt.getPlatformName()
     HelperKt.doInitKoin(driver: Main_iosKt.createDriver())
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
