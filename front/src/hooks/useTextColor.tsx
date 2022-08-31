import { useMantineTheme } from '@mantine/core'
import { useColorScheme } from '@mantine/hooks'

const useTextColor = () => {
    const theme = useMantineTheme()
    const themePref = useColorScheme()

    return themePref === 'dark' ? theme.colors.gray[0] : theme.colors.dark[8]
}

export default useTextColor
