import { MantineThemeOverride } from '@mantine/core'
import { useColorScheme } from '@mantine/hooks'

const useTheme = () => {
    const themePref = useColorScheme()

    console.log(themePref)

    const themeConfig: MantineThemeOverride | undefined = {
        colorScheme: themePref,
    }

    return themeConfig
}

export default useTheme
